package pe.edu.upeu.ventas.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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

import pe.edu.upeu.ventas.entity.Categoria;
import pe.edu.upeu.ventas.service.CategoriaService;
@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
		/**/
		@GetMapping("")
	    public List<Map<String, Object>> findCat() {
	        return categoriaService.readAll();
	    }
		@PostMapping("/")
		public int save(@RequestBody Categoria cat) {		
			return categoriaService.create(cat);		
		}
		@DeleteMapping("/{id}")
		public int delete1(@PathVariable int id) {		
			return categoriaService.delete(id);
		}
		@GetMapping("/{id}")
		public List<Map<String, Object>> read1(@PathVariable int id) {		
			return categoriaService.readAll(id);
		}
		@PutMapping("/")
		public int update1(@Valid @RequestBody Categoria cat) {
			return categoriaService.edtit(cat);
		}
}
