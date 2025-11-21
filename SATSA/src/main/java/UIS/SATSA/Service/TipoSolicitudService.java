package UIS.SATSA.Service;

import UIS.SATSA.DTO.SolicitudDTO;
import UIS.SATSA.DTO.TipoSolicitudDTO;
import UIS.SATSA.Model.Solicitud;
import UIS.SATSA.Model.TipoSolicitud;
import UIS.SATSA.Repository.TipoSolicitudRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.Map;
import java.util.HashMap;
import UIS.SATSA.Repository.SolicitudRepository;

@Service
public class TipoSolicitudService {

    private final TipoSolicitudRepository tipoSolicitudRepository;

    public TipoSolicitudService(TipoSolicitudRepository tipoSolicitudRepository) {
        this.tipoSolicitudRepository = tipoSolicitudRepository;
    }


    @Transactional
    public List<TipoSolicitudDTO> ListarTiposSolicitud() {
        List<TipoSolicitud> tiposSolicitud = tipoSolicitudRepository.findAll();
        List<TipoSolicitudDTO> listaTipoSolicitudDTO = new ArrayList<>();

        for (TipoSolicitud saved : tiposSolicitud) {
            listaTipoSolicitudDTO.add(TipoSolicitudToDTO(saved));
        }
        return listaTipoSolicitudDTO;
    }

    private TipoSolicitudDTO TipoSolicitudToDTO(TipoSolicitud saved) {

        Map<String, Boolean> mapa = new HashMap<>(); // inicialización segura

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapa = mapper.readValue(
                    saved.getCampos(),
                    new TypeReference<Map<String, Boolean>>() {}
            );

        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error al parsear JSON de campos: " + saved.getCampos(), e);
        }

        return new TipoSolicitudDTO(
                saved.getId(),
                saved.getNombre(),
                saved.getInformacion(),
                saved.isDisabled(),
                mapa
        );
    }

}