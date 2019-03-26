package com.azr.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.azr.dao.ProduitRepository;
import com.azr.entities.Produits;

@RestController
public class ProduitsRestService {
	@Autowired
	private ProduitRepository produitrepository;
	
	@RequestMapping(value="/produits",method=RequestMethod.GET)
	public List<Produits> listProduits(){
		return produitrepository.findAll();
	}
	
	@RequestMapping(value="/produits/{id}",method=RequestMethod.GET)
	public Optional<Produits> getProduit(@PathVariable(name="id") Long id){
		return produitrepository.findById(id);
	}
	
	@RequestMapping(value="/produits",method=RequestMethod.POST)
	public Produits save(@RequestBody Produits p){
		return produitrepository.save(p);
	}
	
	@RequestMapping(value="/produits/{id}",method=RequestMethod.PUT)
	public Produits update(@PathVariable(name = "id") Long id,@RequestBody Produits p){
		p.setId(id);
		return produitrepository.save(p);
	}
	
	@RequestMapping(value="/chercher",method=RequestMethod.GET)
	public Page<Produits> chercher(@RequestParam(name="mc",defaultValue="") String mc, 
			@RequestParam(name="page",defaultValue="0") int page,
			@RequestParam(name="size",defaultValue="4")int size){
		return produitrepository
				.chercher("%"+mc+"%",PageRequest.of(page, size));
	}
	
	
}
