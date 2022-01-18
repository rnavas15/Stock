package com.Stock.Stock.Servicios;


import com.Stock.Stock.Entidades.Foto;
import com.Stock.Stock.Respositorios.FotoRepositorio;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FotoServicio {

    @Autowired
    private FotoRepositorio fotoRepositorio;

    @Transactional
    public Foto guardar(MultipartFile archivo) throws Exception {

        if (archivo != null && !archivo.isEmpty()) {
            try {
                System.out.println(archivo.getContentType());
                System.out.println(archivo.getName());

                Foto foto = new Foto();
                foto.setMime(archivo.getContentType());
                foto.setNombre(archivo.getName());
                foto.setContenido(archivo.getBytes());

                return fotoRepositorio.save(foto);

            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;

    }

    @Transactional
    public Foto actualizar(Integer idFoto, MultipartFile archivo) throws Exception {

        if (archivo != null) {
            try {

                Foto foto = new Foto();

                if (idFoto != null) {
                    Optional<Foto> respuesta = fotoRepositorio.findById(idFoto);
                    if (respuesta.isPresent()) {
                        foto = respuesta.get();
                    }
                }

                foto.setMime(archivo.getContentType());
                foto.setNombre(archivo.getName());
                foto.setContenido(archivo.getBytes());

                return fotoRepositorio.save(foto);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;

    }

    @Transactional
    public byte [] obtenerBytes(Integer idFoto) {

        Foto foto = new Foto();
        try {
            if (idFoto != null) {
                Optional<Foto> respuesta = fotoRepositorio.findById(idFoto);
                if (respuesta.isPresent()) {
                    foto = respuesta.get();
                } else {
                    foto = null;
                }
            }
            return foto.getContenido();

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }

    }

}
