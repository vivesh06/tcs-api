package com.tcs.api.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.tcs.api.model.TermsAndConditions;
import com.tcs.api.repository.TcsRepository;

@RestController
public class TcsApi {
	
	@Autowired private TcsRepository tcsRepository;
	
	@RequestMapping(path="/tcs", method=RequestMethod.POST)
	public ResponseEntity<?> createTcs(@RequestBody TermsAndConditions entity, UriComponentsBuilder urlBuilder) {
		TermsAndConditions termsAndConditions = tcsRepository.save(entity);
		URI url = urlBuilder.path("/tcs/{id}").buildAndExpand(termsAndConditions.getId()).toUri();
		return ResponseEntity.created(url).build();
	}
	
	@RequestMapping(path="/tcs/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> getTcs(@PathVariable("id") long id) {
		Optional<TermsAndConditions> optional = tcsRepository.findById(id);
		return optional.isPresent() ?  ResponseEntity.ok().body(optional.get()) : ResponseEntity.notFound().build();
	}
	
	@RequestMapping(path="/tcs", method=RequestMethod.GET)
	public ResponseEntity<?> searchTcs(String name, String channel, String status, String version) { //TODO Not working & Optimize
		List<String> channels = Stream.of(channel).collect(Collectors.toList());
		List<TermsAndConditions> list = tcsRepository.findByNameAndStatusAndVersionAndChannels(name, status, version, channels);
		return null == list || list.isEmpty() ?  ResponseEntity.notFound().build() : ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(path="/tcs/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<?> invalidateTcs(@PathVariable("id") long id, @RequestParam String reason) {
		tcsRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(path="/tcs/{id}/content", method=RequestMethod.GET)
	public ResponseEntity<InputStreamResource> getTcsContent(long id) throws Exception {
		
		Optional<TermsAndConditions> optional = tcsRepository.findById(id);
		
		if(!optional.isPresent() || null == optional.get().getContent() || !optional.get().getContent().hasBinaryContent()) {
			return ResponseEntity.notFound().build();
		}
		
		byte[] tcsContent = optional.get().getContent().toBytes();
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.setContentLength(tcsContent.length);
        responseHeaders.setContentType(MediaType.valueOf(optional.get().getContent().getMediaType()));
        
        try(ByteArrayInputStream inputStream = new ByteArrayInputStream(tcsContent)) {
        	return new ResponseEntity<InputStreamResource>(new InputStreamResource(inputStream), responseHeaders, HttpStatus.OK);
        }
	}

}
