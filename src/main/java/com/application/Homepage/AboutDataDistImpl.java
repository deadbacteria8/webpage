package com.application.Homepage;
import com.domain.model.FullAbout;
import org.springframework.stereotype.Service;
@Service
public class AboutDataDistImpl implements AboutDataDistributor {
    @Override
    public String getData() {
        return "Hallo";
    }
}
