package nz.co.goodspeed.chargenetbe;

import com.amazonaws.http.apache.client.impl.SdkHttpClient;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.cognitoidentityprovider.CognitoIdentityProviderClient;
import software.amazon.awssdk.services.cognitoidentityprovider.model.AttributeType;
import software.amazon.awssdk.services.cognitoidentityprovider.model.CognitoIdentityProviderException;
import software.amazon.awssdk.services.cognitoidentityprovider.model.ConfirmSignUpRequest;
import software.amazon.awssdk.services.cognitoidentityprovider.model.SignUpRequest;

import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@SpringBootTest
class ChargenetbeApplicationTests {
    static final String AWS_CLIENT_ID = "ap69g8hfs5r0pepckapj0b0fj";//TODO PUT IN CONFIG
    @Test
    void contextLoads() {
    }

    @Test
    void getListOfProducts() {
        CognitoIdentityProviderClient cognitoClient = CognitoIdentityProviderClient.builder()
                .region(Region.US_EAST_1)
                .credentialsProvider(
                        ProfileCredentialsProvider.create()
                ).build();


        /*signUp(
                cognitoClient,
                AWS_CLIENT_ID,
                "ingrid@goodspeed.co.za",
                "r34lLyB@dPassword",
                List.of(
                        AttributeType.builder().name("name").value("ingrid").build(),
                        AttributeType.builder().name("family_name").value("goodspeed").build()
                )
        );*/
        confirmSignUp(
                cognitoClient,
                AWS_CLIENT_ID,
                "576867",
                "ingrid@goodspeed.co.za"
        );
    }

    public static void confirmSignUp(CognitoIdentityProviderClient identityProviderClient, String clientId, String code, String userName) {
        try {
            ConfirmSignUpRequest signUpRequest = ConfirmSignUpRequest.builder()
                    .clientId(clientId)
                    .confirmationCode(code)
                    .username(userName)
                    .build();

            identityProviderClient.confirmSignUp(signUpRequest);
            System.out.println(userName +" was confirmed");

        } catch(CognitoIdentityProviderException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

    public static void signUp(CognitoIdentityProviderClient identityProviderClient, String clientId, String userName, String password, List<AttributeType> userAttributes) {
        try {
            SignUpRequest signUpRequest = SignUpRequest.builder()
                    .userAttributes(userAttributes)
                    .username(userName)
                    .clientId(clientId)
                    .password(password)
                    .build();

            identityProviderClient.signUp(signUpRequest);
            System.out.println("User has been signed up ");

        } catch(CognitoIdentityProviderException e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

}
