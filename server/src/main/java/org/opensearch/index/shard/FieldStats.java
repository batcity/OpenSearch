package org.opensearch.index.shard;

import org.opensearch.common.annotation.PublicApi;
import org.opensearch.core.common.io.stream.StreamInput;
import org.opensearch.core.common.io.stream.StreamOutput;
import org.opensearch.core.common.io.stream.Writeable;
import org.opensearch.core.xcontent.ToXContentFragment;
import org.opensearch.core.xcontent.XContentBuilder;

import java.io.IOException;

@PublicApi(since = "1.0.0")
public class FieldStats implements Writeable, ToXContentFragment {

    private final long fieldCount;
    private final long fieldLimit;

    public FieldStats() {
        this.fieldCount = 0;
        this.fieldLimit = 0;
    }

    public FieldStats(long fieldCount, long fieldLimit) {
        this.fieldCount = fieldCount;
        this.fieldLimit = fieldLimit;
    }

    public FieldStats(StreamInput in) throws IOException {
        this.fieldCount = in.readVLong();
        this.fieldLimit = in.readVLong();
    }

    public long getFieldCount() {
        return fieldCount;
    }

    public long getFieldLimit() {
        return fieldLimit;
    }

    @Override
    public void writeTo(StreamOutput out) throws IOException {
        out.writeVLong(fieldCount);
        out.writeVLong(fieldLimit);
    }

    @Override
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        builder.startObject("fields");
        builder.field("count", fieldCount);
        builder.field("limit", fieldLimit);
        builder.endObject();
        return builder;
    }
}
