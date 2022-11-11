package com.example.testawtoti.model.query;

public class FindLogsByHashtagQuery {

    public static final String LOGS_BY_hASHTAG =
                    "SELECT aw_log.id, aw_log.creation_date, aw_log.host, aw_log.details " +
                    "FROM aw_hashtag " +
                    "JOIN aw_hashtag_log ON aw_hashtag.id=aw_hashtag_log.hashtag_id " +
                    "JOIN aw_log ON aw_hashtag_log.log_id = aw_log.id ";
}
