package com.farol.service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.farol.models.Item;
import com.farol.repository.ItemRepository;

import io.swagger.annotations.ApiOperation;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@ApiOperation(value="Retorna uma lista de Itens")
	public List<Item> listaItem(){
		return itemRepository.findAll();
	}
	
	@ApiOperation(value="Retorna um item unico")
	public Item buscarItem(@PathVariable(value="id") long id){
		return itemRepository.findById(id);
	}
	
	@ApiOperation(value="Salva um item")
	public Item salvaItem(@RequestBody Item item) {
		return itemRepository.save(item);
	}
	
	@ApiOperation(value="Deleta um item")
	public void deletaItem(@RequestBody Item item) {
		itemRepository.delete(item);
	}
	
	@ApiOperation(value="Atualiza um item")
	public Item atualizaItem(@RequestBody Item item) {
		return itemRepository.save(item);
	}

	public String buscarUltimaSerie() {
		List<Item> itens = itemRepository.findAll();
		
		if (itens.isEmpty())
			return null;
		
		List<Item> sortedItens = itens.stream()
	            .sorted(Comparator.comparing(Item::getSerie))
	            .collect(Collectors.toList());
		
		return sortedItens.get(sortedItens.size() - 1).getSerie();
	}
	
}
