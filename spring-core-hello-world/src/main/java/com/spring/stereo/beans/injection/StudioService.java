package com.spring.stereo.beans.injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//
//@Component
//@Component("studioService")

@Service
public class StudioService {

    @Autowired
    private StudioRepository studioRepository;

    private MarketPlaceClient marketPlaceClient;

    public StudioService(@Autowired MarketPlaceClient marketPlaceClient) {
        this.marketPlaceClient = marketPlaceClient;
    }

    public Object getStudio(String studioId)
    {
        System.out.println(marketPlaceClient);
        return studioRepository.findStudioById(studioId);
    }
}
