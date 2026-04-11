package org.opensearch.action.admin.indices.stats;

import org.opensearch.core.xcontent.ToXContentObject;
import org.opensearch.core.xcontent.XContentBuilder;

import java.io.IOException;

public class FieldStats implements ToXContentObject {

    private final int fieldCount;
    private final int fieldLimit;

    public FieldStats(int fieldCount, int fieldLimit) {
        this.fieldCount = fieldCount;
        this.fieldLimit = fieldLimit;
    }

    public int getFieldCount() {
        return fieldCount;
    }

    public int getFieldLimit() {
        return fieldLimit;
    }

    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.startObject("field_stats");
        builder.field("field_count", fieldCount);
        builder.field("field_limit", fieldLimit);
        builder.endObject();
        return builder;
    }
}
