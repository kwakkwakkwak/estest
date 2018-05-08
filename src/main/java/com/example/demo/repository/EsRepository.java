package com.example.demo.repository;


import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

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

    public Map<String, Object> getResponse(String index, String type, String id) {
    	
    	return client.prepareGet(index, type, id).get().getSource();
    }
    
    public IndexResponse indexResponse(String index, String type, String id) throws IOException  {
    	return client.prepareIndex(index, type, id)
        .setSource(jsonBuilder()
                    .startObject()
                        .field("user", "kimchy")
                        .field("postDate", new Date())
                        .field("message", "trying out Elasticsearch")
                    .endObject()
                  )
        .get();
    
    }
    
    public DeleteResponse deleteResponse(String index, String type, String id)  {
    	return client.prepareDelete(index, type, id).get();
    }
    
    public UpdateResponse update() throws IOException, InterruptedException, ExecutionException {
    	UpdateRequest updateRequest = new UpdateRequest();
    	updateRequest.index("twitter");
    	updateRequest.type("view");
    	updateRequest.id("3");
    	updateRequest.doc(jsonBuilder()
    	        .startObject()
    	            .field("name", "test2")
    	        .endObject());
    	return client.update(updateRequest).get();
    }
    
    public HashMap<String, Object> findSongWithPrefix(String prefix) {

        SearchResponse response = client.prepareSearch("twitter")
                .setTypes("view")
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