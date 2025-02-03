package com.vdtry.apidoc.vnpay.category;

import lombok.*;

public abstract class CategoryDTO {
    @Builder
    @Data
    public static class CreateRequest {
        public String name;
        public String description;
    }

    @Builder
    @Data
    public static class UpdateRequest {
        public String id;
        public String name;
        public String description;
    }

    @Builder
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class CategoryResponse {
        public String id;
        public String name;
        public String description;
    }
}
