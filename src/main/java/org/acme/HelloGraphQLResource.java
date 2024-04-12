package org.acme;

import java.util.List;

import org.eclipse.microprofile.graphql.DefaultValue;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.eclipse.microprofile.graphql.Source;

@GraphQLApi
public class HelloGraphQLResource {

    @Query
    @Description("getMyEntity")

    public MyEntity getMyEntity() {
        MyEntity myEntity =  MyEntity.findById(2);
        return myEntity;
    }

    @Name("items")
    public List<MyEntityItem> inventoryListItems(@Source MyEntity myEntity) {
        return MyEntityItem.find("myEntity = ?1", myEntity).list();
    }

}



