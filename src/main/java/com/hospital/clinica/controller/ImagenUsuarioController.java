package com.hospital.clinica.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.Deflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.HttpStatus;

import com.hospital.clinica.dao.ImagenUsuarioDao;
import com.hospital.clinica.model.ImagenUsuario;
import com.hospital.clinica.service.ImagenUsuarioService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/imagen")
public class ImagenUsuarioController {
	
	@Autowired
	private ImagenUsuarioService<ImagenUsuario> services; 
	
	@Autowired
	ImagenUsuarioDao dao;

	@GetMapping(value="/usuario",produces = "application/json")
	public List<ImagenUsuario> listar(){
		return services.lista();
	}
	
	@GetMapping(value="/alcaldia/{id}", produces = "application/json")
	public Optional<ImagenUsuario> listaId(@PathVariable("id") int id) {
		return services.listaId(id);
	}
	
	@PostMapping(value="/nueva")
	public HttpStatus registrar (@RequestParam("miArchivo") MultipartFile file) throws IOException {
		System.out.println("Original Image Byte Size - " + file.getBytes().length);
		ImagenUsuario img = new ImagenUsuario(file.getOriginalFilename(), file.getContentType(),
				compressBytes(file.getBytes()));
		dao.save(img);
		return (HttpStatus.OK);
	
		
		//return (ImagenUsuario) services.registrar(imagenUsuario);
	}
	
	@PutMapping(value="/actualizar",produces = "application/json", consumes = "application/json")
	public ImagenUsuario modificar (@RequestBody ImagenUsuario imagenUsuario) {
		return (ImagenUsuario) services.modificar(imagenUsuario);
	}
	
	@DeleteMapping(value="/eliminar/{id}")
	public void eliminar (@PathVariable("id") int id) {
		services.eliminar(id);
	}
	
	public static byte[] compressBytes(byte[] data) {
		Deflater deflater = new Deflater();
		deflater.setInput(data);
		deflater.finish();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		while (!deflater.finished()) {
			int count = deflater.deflate(buffer);
			outputStream.write(buffer, 0, count);
		}
		try {
			outputStream.close();
		} catch (IOException e) {
		}
		System.out.println("Compressed Image Byte Size - " + outputStream.toByteArray().length);
		return outputStream.toByteArray();
	}

}
