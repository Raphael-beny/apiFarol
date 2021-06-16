package com.farol.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farol.models.DisponibilidadeEnum;
import com.farol.models.Item;
import com.farol.models.StatusEnum;
import com.farol.service.ItemService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value="/api")
@Api(value="API REST Itens de Inventario")
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@ApiOperation(value="Retorna uma lista de Itens")
	@GetMapping("/itens")
	public List<Item> listaItem(){
		return itemService.listaItem();
	}
	
	@ApiOperation(value="Retorna um item unico")
	@GetMapping("/item/{id}")
	public Item buscarItem(@PathVariable(value="id") long id){
		return itemService.buscarItem(id);
	}
	
	@ApiOperation(value="Salva um item")
	@PostMapping("/item")
	public Item salvaItem(@RequestBody Item item) throws Exception {
		item.setSerie(buscarSequenciaSerie());		
		return itemService.salvaItem(item);
	}
	
	private String buscarSequenciaSerie() {
		String ultimaSerie = itemService.buscarUltimaSerie();
		
		if (ultimaSerie == null)
			return "00001";
		
		int proximaSerie = Integer.parseInt(ultimaSerie) + 1;
		return String.format("%05d", proximaSerie);
	}
	
	
	@ApiOperation(value="Deleta um item")
	@DeleteMapping("/item")
	public void deletaItem(@RequestBody Item item) {
		itemService.deletaItem(item);
	}
	
	@ApiOperation(value="Atualiza um item")
	@PutMapping("/item")
	public Item atualizaItem(@RequestBody Item item) {
		return itemService.atualizaItem(item);
	}
	
	@ApiOperation(value="Atualiza disponibilidade de item")
	@PutMapping("/item/atualizaDisponibilidade/{id}")
	public Item atualizaItemDisponibilidade(@PathVariable(value="id") long id) {
		Item item = itemService.buscarItem(id);
		if (DisponibilidadeEnum.DISPONIVEL.getDisponibilidade() == item.getDisponibilidade()) {
			item.setDisponibilidade(DisponibilidadeEnum.INDISPONIVEL.getDisponibilidade());
		}else {
			item.setDisponibilidade(DisponibilidadeEnum.DISPONIVEL.getDisponibilidade());
		}
		return itemService.atualizaItem(item);
	}
	
	@ApiOperation(value="Atualiza status de item")
	@PutMapping("/item/atualizaStatus/{id}")
	public Item atualizaItemStatus(@PathVariable(value="id") long id) {
		Item item = itemService.buscarItem(id);
		if (StatusEnum.ATIVO.getStatus() == item.getStatus()) {
			item.setStatus(StatusEnum.INATIVO.getStatus());
		}else {
			item.setStatus(StatusEnum.ATIVO.getStatus());
		}
		return itemService.atualizaItem(item);
	}
	

}