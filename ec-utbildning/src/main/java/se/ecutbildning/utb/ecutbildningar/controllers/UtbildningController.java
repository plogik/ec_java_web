package se.ecutbildning.utb.ecutbildningar.controllers;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import se.ecutbildning.utb.ecutbildningar.NotFoundException;
import se.ecutbildning.utb.ecutbildningar.domain.entities.Kurs;
import se.ecutbildning.utb.ecutbildningar.domain.entities.Utbildning;
import se.ecutbildning.utb.ecutbildningar.domain.repositories.AdressRepository;
import se.ecutbildning.utb.ecutbildningar.domain.repositories.KursRepository;
import se.ecutbildning.utb.ecutbildningar.domain.repositories.UtbildningRepository;
import se.ecutbildning.utb.ecutbildningar.presentation.formmodels.UtbildningForm;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/utbildning")
public class UtbildningController {
    private UtbildningRepository utbildningRepository;
    private AdressRepository adressRepository;
    private KursRepository kursRepository;

    private ModelMapper mapper = new ModelMapper();

    public UtbildningController(
            UtbildningRepository utbildningRepository,
            AdressRepository adressRepository,
            KursRepository kursRepository) {
        this.utbildningRepository = utbildningRepository;
        this.adressRepository = adressRepository;
        this.kursRepository = kursRepository;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("utbildningar",
                mapper.map(utbildningRepository.findAll(),
                        new TypeToken<Iterable<UtbildningForm>>(){}.getType())
                );
        return "utbildning/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable String id, Model model) {
        Utbildning utbildning = utbildningRepository.findById(id).get();
        if(utbildning == null) {
            throw new NotFoundException();
        }
        UtbildningForm utbildningForm = mapper.map(utbildning, UtbildningForm.class);
        utbildningForm.setAllaAdresser(adressRepository.findAll());
        utbildningForm.setAllaKurser(kursRepository.findAll());
        model.addAttribute("utbildningForm", utbildningForm);
        return "utbildning/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid UtbildningForm utbildningForm, BindingResult result) {
        if(result.hasErrors()) {
            utbildningForm.setAllaAdresser(adressRepository.findAll());
            utbildningForm.setAllaKurser(kursRepository.findAll());
            return "utbildning/edit";
        }
        Utbildning utbildning = mapper.map(utbildningForm, Utbildning.class);
        //utbildning.getKurser().stream().forEach(k -> k.setUtbildning(utbildning));
        utbildningRepository.save(utbildning);
        return "redirect:/utbildning/list";
    }
}
