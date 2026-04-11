package org.opensearch.index.mapper;

import org.opensearch.index.mapper.Mapper;
import org.opensearch.index.mapper.ObjectMapper;

import java.util.Collection;

public final class FieldCountHelper {

    private FieldCountHelper() {}

    public static int countFields(Mapper mapper) {
        if (mapper == null) return 0;

        int count = 0;

        if (mapper instanceof ObjectMapper) {
            ObjectMapper objectMapper = (ObjectMapper) mapper;

            Collection<Mapper> children = objectMapper.mappers().values();
            for (Mapper child : children) {
                count += countFields(child);
            }
        } else {
            // Leaf field mapper
            return 1;
        }

        return count;
    }
}
