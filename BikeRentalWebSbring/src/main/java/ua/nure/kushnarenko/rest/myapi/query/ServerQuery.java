package ua.nure.kushnarenko.rest.myapi.query;

import java.util.HashMap;

public interface ServerQuery {
    String sendGetQuery(String query);

    String sendPostQuery(String query, HashMap<String, Object> params);
}
