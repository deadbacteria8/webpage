package com.application.dto;


import com.domain.model.About;
import com.domain.model.Socials;

public record FullAbout(Socials socials, About about) { }
