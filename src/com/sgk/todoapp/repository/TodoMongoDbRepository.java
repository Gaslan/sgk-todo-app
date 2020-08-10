package com.sgk.todoapp.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.Block;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.sgk.todoapp.model.TodoDvo;

public class TodoMongoDbRepository implements TodoCrud {
	
	private static final String CONNECTION_CODE = "mongodb+srv://gaslandev:Sgk123456@cluster0-9bbwr.mongodb.net/sgk-todo-app?retryWrites=true&w=majority";
	private static final String DATABASE_NAME = "sgk-todo-app";
	
	
	private MongoDatabase connect() {
		MongoClient mongoClient = MongoClients.create(CONNECTION_CODE);
		return mongoClient.getDatabase(DATABASE_NAME);
	}

	@Override
	public void create(TodoDvo todo) {

		Document doc = new Document();
		doc.append("title", todo.getTitle());
		doc.append("detail", todo.getDetail());
		doc.append("status", todo.getStatus());
		doc.append("creationDate", LocalDateTime.now().toString());
		
		MongoDatabase database = connect();
		MongoCollection<Document> collection = database.getCollection("todos");
		collection.insertOne(doc);
	}

	@Override
	public TodoDvo read(String id) {
		MongoDatabase database = connect();
		MongoCollection<Document> collection = database.getCollection("todos");
		return collection.find(Filters.eq("_id", new ObjectId(id)), TodoDvo.class).first();
	}

	@Override
	public List<TodoDvo> readAll() {
		
		MongoDatabase database = connect();
		MongoCollection<Document> collection = database.getCollection("todos");
		
		List<TodoDvo> resultList = new ArrayList<>();
		
		MongoCursor<Document> it = collection.find().iterator();
		
		while (it.hasNext()) {
			Document doc = (Document) it.next();
			
			TodoDvo todo = new TodoDvo();
			todo.setId(doc.getObjectId("_id").toString());
			todo.setTitle(doc.getString("title"));
			todo.setDetail(doc.getString("detail"));
			todo.setStatus(doc.getInteger("status", 0));
			todo.setCreationDate(LocalDateTime.parse(doc.getString("creationDate")));
			
			resultList.add(todo);
		}
		
		return resultList;
	}

	@Override
	public void update(TodoDvo todo) {

		Document doc = new Document();
		doc.append("title", todo.getTitle());
		doc.append("detail", todo.getDetail());
		doc.append("detail", todo.getStatus());
		doc.append("creationDate", LocalDateTime.now().toString());
		
		MongoDatabase database = connect();
		MongoCollection<Document> collection = database.getCollection("todos");
		collection.updateOne(new Document("_id", todo.getId()), doc);
	}

	@Override
	public void delete(String id) {
		
		MongoDatabase database = connect();
		MongoCollection<Document> collection = database.getCollection("todos");
		
//		FindIterable<Document> findIterable = collection.find(new Document());
//		Block<Document> printBlock = new Block<Document>() {
//		    @Override
//		    public void apply(final Document document) {
//		        System.out.println(document.toJson());
//		    }
//		};
//		findIterable.forEach(printBlock);
//		System.out.println(id);
		
		collection.deleteOne(Filters.eq("_id", new ObjectId(id)));
	}

}
