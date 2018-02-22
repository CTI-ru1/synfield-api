package gr.cti.ru1.synfield.client;

import gr.cti.ru1.synfield.client.model.measurements.SynfieldMeasurementsPage;
import gr.cti.ru1.synfield.client.model.sensors.SynfieldSensorsPage;
import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Synfield Java Object.
 *
 * @author Dimitrios Amaxilatis
 */
public final class Synfield {
    /**
     * LOGGER.
     */
    private static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getLogger(Synfield.class);

    /**
     * The basic authentication token form Synfield app.
     */
    private String basiscAuthenticationToken;
    /**
     * Base url of the Synfield API, by default the testing server is used.
     */
    private String baseUrlString = "http://api-synfield.synelixis.com";


    /**
     * Default Constructor.
     */
    public Synfield() {
        basiscAuthenticationToken = null;
    }

    /**
     * <p>Creates a Synfield Api for the given base url.</p>
     *
     * @param baseUrl The base url to use for the API calls.
     */
    public Synfield(final String baseUrl) {
        this.baseUrlString = baseUrl;
        basiscAuthenticationToken = null;
    }

    public SynfieldSensorsPage getSensors(final String mac) throws IOException {
        final String responseString = getPage("/v1/gateway/" + mac + "/sensors/");
        return new ObjectMapper().readValue(responseString, SynfieldSensorsPage.class);
    }

    public SynfieldMeasurementsPage getMeasurements(final String mac) throws IOException {
        final String responseString = getPage("/v1/gateway/" + mac + "/measurements/");
        return new ObjectMapper().readValue(responseString, SynfieldMeasurementsPage.class);
    }

    public SynfieldMeasurementsPage getMeasurements(final String mac, final String startDate, final String endDate) throws IOException {
        final String responseString = getPage("/v1/gateway/" + mac + "/measurements/" + startDate + "/" + endDate + "/?limit=2000");
        return new ObjectMapper().readValue(responseString, SynfieldMeasurementsPage.class);
    }

    /**
     * Authenticates the user.
     *
     * @param username Synfield username.
     * @param password Synfield password.
     * @return true if authentication succeeded, false if authentication failed.
     */
    public void authenticate(final String username, final String password) {
        final String plainToken = new StringBuilder().append(username).append(":").append(password).toString();
        basiscAuthenticationToken = new String(Base64.encodeBase64(plainToken.getBytes(Charset.forName("UTF-8"))));
    }

//    }

    /**
     * <p>Do a GET request for the given API path and return the response as a String.</p>
     *
     * @param path The API path to do the GET request
     * @return The API call response as a String
     * @throws java.io.IOException if a connection cannot be established
     */
    private String getPage(final String path) throws IOException {
        final Client client = ClientBuilder.newClient();
        final javax.ws.rs.core.Response response = client.target(baseUrlString)
                .path(path)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("Authorization", "Basic " + basiscAuthenticationToken)
                .header("Accept", "application/json")
                .get();
        LOGGER.debug("status: " + response.getStatus());
        return response.readEntity(String.class);
    }
}
