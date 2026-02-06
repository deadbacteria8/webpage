package com.application.socials;

import com.domain.models.Socials;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SocialMediaServiceTest {

    @Test
    void testCreateSocials() {

        SocialMediaRepository repoMock = mock(SocialMediaRepository.class);
        when(repoMock.createSocials(any(Socials.class), eq(1L))).thenReturn(42L);
        SocialMediaService service = new SocialMediaService(repoMock);
        Long result = service.createSocials("githubUser", "linkedinUser", 1L);
        assertEquals(42L, result);
        verify(repoMock, times(1)).createSocials(any(Socials.class), eq(1L));
    }
}
