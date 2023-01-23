package activity.requests;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(builder = CreateExerciseRequest.Builder.class)
public class CreateExerciseRequest {
}
