package ru.ifmo.wst.lab1.rs;

import lombok.SneakyThrows;
import ru.ifmo.wst.lab.ExterminatusPaths;
import ru.ifmo.wst.lab.ParamNames;
import ru.ifmo.wst.lab1.dao.ExterminatusDAO;
import ru.ifmo.wst.lab1.model.ExterminatusEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Date;
import java.util.List;

@RequestScoped
@Path(ExterminatusPaths.ROOT_PATH)
@Produces({MediaType.APPLICATION_JSON})
public class ExterminatusResource {

    public static ExterminatusDAO GLOBAL_DAO;

    @Inject
    private ExterminatusDAO exterminatusDAO;

    public ExterminatusResource() {
        exterminatusDAO = GLOBAL_DAO;
    }

    @GET
    @Path(ExterminatusPaths.FIND_ALL_PATH)
    @SneakyThrows
    public List<ExterminatusEntity> findAll() {
        return exterminatusDAO.findAll();
    }

    @GET
    @Path(ExterminatusPaths.FILTER_PATH)
    @SneakyThrows
    public List<ExterminatusEntity> filter(@QueryParam(ParamNames.ID) Long id, @QueryParam(ParamNames.INTIATOR) String initiator,
                                           @QueryParam(ParamNames.REASON) String reason, @QueryParam(ParamNames.METHOD) String method,
                                           @QueryParam(ParamNames.PLANET) String planet, @QueryParam(ParamNames.DATE) Date date) {
        return exterminatusDAO.filter(id, initiator, reason, method, planet, date);
    }
}
