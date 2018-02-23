package gr.cti.ru1.synfield.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import gr.cti.ru1.synfield.client.model.v1.measurements.SynfieldMeasurementsPage;
import gr.cti.ru1.synfield.client.model.v1.sensors.SynfieldSensorsPage;
import gr.cti.ru1.synfield.client.model.v2.Field;
import gr.cti.ru1.synfield.client.model.v2.LatestMeasurement;
import gr.cti.ru1.synfield.client.model.v2.Measurements;
import gr.cti.ru1.synfield.client.model.v2.Node;
import gr.cti.ru1.synfield.client.model.v2.SensingServices;
import org.apache.commons.codec.binary.Base64;

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
    private String baseUrlv1 = "http://api-synfield.synelixis.com";
    private String baseUrlv2 = "https://staging.synfield.synelixis.com/en/api/v1/";
    
    private final ObjectMapper mapper = new ObjectMapper();
    
    /**
     * Default Constructor.
     */
    public Synfield() {
        basiscAuthenticationToken = null;
    }
    
    /**
     * <p>Creates a Synfield Api for the given base url.</p>
     *
     * @param baseUrlv1 The base url to use for the v1 API calls.
     * @param baseUrlv2 The base url to use for the v2 API calls.
     */
    public Synfield(final String baseUrlv1, final String baseUrlv2) {
        this.baseUrlv1 = baseUrlv1;
        this.baseUrlv2 = baseUrlv2;
        basiscAuthenticationToken = null;
    }
    
    //V1
    public SynfieldSensorsPage getSensors(final String mac) throws IOException {
        final String responseString = getPagev1("/v1/gateway/" + mac + "/sensors/");
        return new ObjectMapper().readValue(responseString, SynfieldSensorsPage.class);
    }
    
    public SynfieldMeasurementsPage getMeasurements(final String mac) throws IOException {
        final String responseString = getPagev1("/v1/gateway/" + mac + "/measurements/");
        return new ObjectMapper().readValue(responseString, SynfieldMeasurementsPage.class);
    }
    
    public SynfieldMeasurementsPage getMeasurements(final String mac, final String startDate, final String endDate) throws IOException {
        final String responseString = getPagev1("/v1/gateway/" + mac + "/measurements/" + startDate + "/" + endDate + "/?limit=2000");
        return new ObjectMapper().readValue(responseString, SynfieldMeasurementsPage.class);
    }
    
    //V2
    public Field[] getFields() throws IOException {
        final String responseString = getPagev2("/fields");
        return mapper.readValue(responseString, Field[].class);
    }
    
    public SensingServices[] getNodeSensingServices(Node node) throws IOException {
        final String responseString = getPagev2("/nodes/" + node.getSerialNumber() + "/sensing_services");
        return mapper.readValue(responseString, SensingServices[].class);
    }
    
    public LatestMeasurement[] getNodeLatestMeasurements(Node node) throws IOException {
        final String responseString = getPagev2("/nodes/" + node.getSerialNumber() + "/measurements/latest");
        return mapper.readValue(responseString, LatestMeasurement[].class);
    }
    
    public Measurements getNodeMeasurements(Node node, String from, String to) throws IOException {
        final String responseString = getPagev2("/nodes/" + node.getSerialNumber() + "/measurements/" + from + "/" + to);
        return mapper.readValue(responseString, Measurements.class);
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
    
    /**
     * <p>Do a GET request for the given API path and return the response as a String.</p>
     *
     * @param path The API path to do the GET request
     * @return The API call response as a String
     * @throws java.io.IOException if a connection cannot be established
     */
    private String getPagev1(final String path) throws IOException {
        return getPage(baseUrlv1, path);
    }
    
    private String getPagev2(final String path) throws IOException {
        return getPage(baseUrlv2, path);
    }
    
    private String getPage(final String baseUrl, final String path) throws IOException {
        final Client client = ClientBuilder.newClient();
        final javax.ws.rs.core.Response response = client.target(baseUrl).path(path).request(MediaType.APPLICATION_JSON_TYPE).header("Authorization", "Basic " + basiscAuthenticationToken).header("Accept", "application/json").get();
        LOGGER.debug("status: " + response.getStatus());
        return response.readEntity(String.class);
    }
}
