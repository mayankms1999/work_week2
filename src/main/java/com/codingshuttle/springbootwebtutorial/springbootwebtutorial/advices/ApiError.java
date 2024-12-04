package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.advices;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@Builder
public class ApiError {




    private HttpStatus status;
    private String message;
    private List<String> subErrors;

    // Manually implement the builder method
//    public static ApiErrorBuilder builder() {
//        return new ApiErrorBuilder();
//    }
//
//    public static class ApiErrorBuilder {
//        private HttpStatus status;
//        private String message;
//        private List<String> subErrors;
//
//        public ApiErrorBuilder status(HttpStatus status) {
//            this.status = status;
//            return this;
//        }
//
//        public ApiErrorBuilder message(String message) {
//            this.message = message;
//            return this;
//        }
//
//        public ApiErrorBuilder subErrors(List<String> subErrors) {
//            this.subErrors = subErrors;
//            return this;
//        }
//
//        public ApiError build() {
//            ApiError apiError = new ApiError();
//            apiError.status = this.status;
//            apiError.message = this.message;
//            apiError.subErrors = this.subErrors;
//            return apiError;
        }

