package com.hospital.clinica.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

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
	
	@GetMapping(path = { "/get/{idImagen}" })
	public ImagenUsuario getImage(@PathVariable("idImagen") Integer idImagen) throws IOException {
		final Optional<ImagenUsuario> retrievedImage = dao.findById(idImagen);
		ImagenUsuario img = new ImagenUsuario(retrievedImage.get().getNombre(), retrievedImage.get().getType(),
				decompressBytes(retrievedImage.get().getImagenByte()));
		return img;
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
	
	
	// uncompress the image bytes before returning it to the angular application
	public static byte[] decompressBytes(byte[] data) {
		Inflater inflater = new Inflater();
		inflater.setInput(data);
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream(data.length);
		byte[] buffer = new byte[1024];
		try {
			while (!inflater.finished()) {
				int count = inflater.inflate(buffer);
				outputStream.write(buffer, 0, count);
			}
			outputStream.close();
		} catch (IOException ioe) {
		} catch (DataFormatException e) {
		}
		return outputStream.toByteArray();
	

}
	
}
