package electronics.store.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import electronics.store.db.dao.StoreRepository;
import electronics.store.db.model.StorePE;
import electronics.store.rest.model.StoreDTO;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private StoreRepository storeRepository;
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<StoreDTO> listAll() {
        return storeRepository.findAll().stream()
                .map(storePE -> objectMapper.convertValue(storePE, StoreDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        storeRepository.deleteById(id);
    }

    @Override
    public StoreDTO add(String name) {
        return objectMapper.convertValue(storeRepository.save(new StorePE(name)), StoreDTO.class);
    }

    @Override
    public StoreDTO findById(Integer id) {
        var storePE = storeRepository.findById(id);
        return storePE.map(store -> objectMapper.convertValue(storePE, StoreDTO.class)).orElse(null);
    }
}
