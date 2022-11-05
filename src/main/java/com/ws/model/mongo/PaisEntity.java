package com.ws.model.mongo;

import io.quarkus.mongodb.panache.PanacheMongoEntity;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.*;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@MongoEntity(collection = "Pais")
public class PaisEntity {
    @BsonId
    private ObjectId id;
    private String name;
    private String code;
    private String capital;
}
