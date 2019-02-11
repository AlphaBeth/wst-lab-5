package ru.ifmo.wst.lab1;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import lombok.Getter;
import ru.ifmo.wst.lab.ExterminatusPaths;
import ru.ifmo.wst.lab.ParamNames;
import ru.ifmo.wst.lab1.model.ExterminatusEntity;
import ru.ifmo.wst.lab1.model.Filter;

import javax.ws.rs.core.MediaType;
import java.util.List;

public class ExterminatusResourceClient {

    public static final GenericType<List<ExterminatusEntity>> EXTERMINATUS_LIST =
            new GenericType<List<ExterminatusEntity>>() {
            };
    @Getter
    private final String baseUrl;
    private final WebResource findAllResource;
    private final WebResource filterResource;


    public ExterminatusResourceClient(String baseUrl) {
        this.baseUrl = baseUrl + ExterminatusPaths.ROOT_PATH;
        this.findAllResource = Client.create().resource(url(ExterminatusPaths.FIND_ALL_PATH));
        this.filterResource = Client.create().resource(url(ExterminatusPaths.FILTER_PATH));
    }

    public List<ExterminatusEntity> findAll() {
        return findAllResource.accept(MediaType.APPLICATION_JSON_TYPE).get(EXTERMINATUS_LIST);
    }

    public List<ExterminatusEntity> filter(Filter filter) {
        WebResource resource = filterResource;
        resource = setParamIfNotNull(resource, ParamNames.ID, filter.getId());
        resource = setParamIfNotNull(resource, ParamNames.INTIATOR, filter.getInitiator());
        resource = setParamIfNotNull(resource, ParamNames.METHOD, filter.getMethod());
        resource = setParamIfNotNull(resource, ParamNames.PLANET, filter.getPlanet());
        resource = setParamIfNotNull(resource, ParamNames.REASON, filter.getReason());
        resource = setParamIfNotNull(resource, ParamNames.DATE, filter.getDate());
        return resource.accept(MediaType.APPLICATION_JSON_TYPE).get(EXTERMINATUS_LIST);
    }

    private String url(String endpointAddress) {
        return baseUrl + endpointAddress;
    }

    private WebResource setParamIfNotNull(WebResource resource, String paramName, Object value) {
        if (value == null) {
            return resource;
        }
        return resource.queryParam(paramName, value.toString());
    }
}
