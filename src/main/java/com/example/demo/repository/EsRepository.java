package com.example.demo.repository;


import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.example.demo.vo.TwitterVO;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EsRepository {
	
	@Autowired
	private Client client;

    public Map<String, Object> get(TwitterVO vo) {
    	
    	return client.prepareGet(vo.getIndex(),vo.getType(),vo.getId()).get().getSource();
    }
    
    public IndexResponse index(TwitterVO vo) throws IOException  {
    	return client.prepareIndex(vo.getIndex(),vo.getType(),vo.getId())
        .setSource(jsonBuilder()
                    .startObject()
                        .field("user", "kimchy")
                        .field("postDate", new Date())
                        .field("message", "trying out Elasticsearch")
                    .endObject()
                  )
        .get();
    
    }
    
    public DeleteResponse delete(TwitterVO vo)  {
    	return client.prepareDelete(vo.getIndex(), vo.getType(), vo.getId()).get();
    }
    
    public UpdateResponse update(TwitterVO vo) throws IOException, InterruptedException, ExecutionException {
    	UpdateRequest updateRequest = new UpdateRequest();
    	updateRequest.index(vo.getIndex());
    	updateRequest.type(vo.getType());
    	updateRequest.id(vo.getId());
    	updateRequest.doc(jsonBuilder()
    	        .startObject()
                    .field("postDate", new Date())
    	            .field("Message", vo.getMessage())
    	        .endObject());
    	return client.update(updateRequest).get();
    }
    
    public HashMap<String, Object> findPrefixTwitter(TwitterVO twitterVO, String prefix) {

        SearchResponse response = client.prepareSearch(twitterVO.getIndex())
                .setTypes(twitterVO.getType())
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
                .setQuery(QueryBuilders.prefixQuery("user",prefix))
                .setFrom(0).setSize(20).setExplain(true)
                .get();

        SearchHits hits = response.getHits();

        HashMap<String ,Object> result = new HashMap<>();

        result.put("total", hits.getTotalHits());
        result.put("contentsList", hits.getHits());

        return result;
    }
}