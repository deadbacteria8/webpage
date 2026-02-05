package com.application.dto;


import com.domain.models.About;
import com.domain.models.Socials;

public record FullAbout(Socials socials, About about) { }
