package com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Service;

import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.HorarioYDiaClass;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Model.Usuario;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repositories.HorarioYDiaClassRepository;
import com.ComprandoEnCasa.ComprandoEnCasaBackEnd.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HorarioYDiaClassService {

    @Autowired
    private HorarioYDiaClassRepository horarioYDiaClassRepository;

    @Transactional
    public HorarioYDiaClass save(HorarioYDiaClass model) {
        return this.horarioYDiaClassRepository.save(model);
    }
}
