package lambda;

import activity.requests.GetAllExercisesRequest;
import activity.results.GetAllExercisesResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class GetAllExerciseByMuscleLambda extends LambdaActivityRunner<GetAllExercisesRequest, GetAllExercisesResult>
    implements RequestHandler<LambdaRequest<GetAllExercisesRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<GetAllExercisesRequest> input, Context context) {
        return super.runActivity(() -> input.fromPath(path -> GetAllExercisesRequest.builder()
                .withExerciseMuscle(path.get("workingMuscle"))
                .build()), (request, serviceComponent) -> serviceComponent.provideGetAllExercisesByMuscle().handleRequest(request));
    }
}
