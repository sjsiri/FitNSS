package lambda;

import activity.requests.CreateWorkoutPlanRequest;
import activity.results.CreateWorkoutPlanResult;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class CreateWorkoutPlanLambda extends LambdaActivityRunner<CreateWorkoutPlanRequest, CreateWorkoutPlanResult>
    implements RequestHandler<LambdaRequest<CreateWorkoutPlanRequest>, LambdaResponse> {

    @Override
    public LambdaResponse handleRequest(LambdaRequest<CreateWorkoutPlanRequest> input, Context context) {
        return super.runActivity(
                () -> input.fromBody(CreateWorkoutPlanRequest.class),
                (request, serviceComponent) -> serviceComponent.provideCreateWorkoutPlanActivity().handleRequest(request)
        );
    }
}
