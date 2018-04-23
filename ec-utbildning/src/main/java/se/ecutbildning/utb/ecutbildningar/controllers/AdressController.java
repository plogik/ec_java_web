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
import se.ecutbildning.utb.ecutbildningar.domain.entities.Adress;
import se.ecutbildning.utb.ecutbildningar.domain.repositories.AdressRepository;
import se.ecutbildning.utb.ecutbildningar.domain.repositories.UtbildningRepository;
import se.ecutbildning.utb.ecutbildningar.presentation.formmodels.AdressForm;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/adress")
public class AdressController {
    private AdressRepository adressRepository;
    private UtbildningRepository utbildningRepository;
    private ModelMapper mapper;

    public AdressController(
            AdressRepository adressRepository,
            UtbildningRepository utbildningRepository,
            ModelMapper mapper) {
        this.adressRepository = adressRepository;
        this.utbildningRepository = utbildningRepository;
        this.mapper = mapper;
    }

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("adresser",
                mapper.map(adressRepository.findAll(),
                        new TypeToken<List<AdressForm>>(){}.getType()));
        return "adress/list";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        Adress adress = adressRepository.findById(id).get();
        if(adress == null) {
            throw new NotFoundException();
        }
        model.addAttribute("adressForm", mapper.map(adress, AdressForm.class));
        return "adress/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@Valid AdressForm adressForm, BindingResult result) {
        if(result.hasErrors()) {
            return "adress/edit";
        }
        adressRepository.save(mapper.map(adressForm, Adress.class));
        return "redirect:/adress/list";
    }

    @GetMapping("/create")
    public String create(AdressForm adressForm) {
        return "adress/edit";
    }

    @PostMapping("/create")
    public String create(@Valid AdressForm adressForm, BindingResult result) {
        if(result.hasErrors()) {
            return "adress/edit";
        }
        adressRepository.save(mapper.map(adressForm, Adress.class));
        return "redirect:/adress/list";
    }

    @GetMapping("/confirmdelete/{id}")
    public String confirmdelete(@PathVariable Long id, Model model) {
        Adress adress = adressRepository.findById(id).get();
        if(adress == null) {
            throw new NotFoundException();
        }
        model.addAttribute("adressForm", mapper.map(adress, AdressForm.class));
        return "adress/delete";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Adress adress = adressRepository.findById(id).get();
        if(adress == null) {
            throw new NotFoundException();
        }
        adressRepository.delete(adress);
        return "redirect:/adress/list";
    }
}
