package com.olszewska.ticket.reservation.service.Implementation;

import com.olszewska.ticket.reservation.model.Screening;
import com.olszewska.ticket.reservation.repository.ScreeningRepository;
import com.olszewska.ticket.reservation.service.ScreeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service("screeningService")
@Transactional
public class ScreeningServiceImpl implements ScreeningService{

    @Qualifier("screeningRepository")
    @Autowired
    private ScreeningRepository screeningRepository;

    public List<Screening> findAllScreenings() {
        return screeningRepository.findAllScreenings();
    }

    public Screening findById(int id) {
        return screeningRepository.findById(id);
    }
}
