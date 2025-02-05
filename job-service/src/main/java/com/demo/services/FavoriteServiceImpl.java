package com.demo.services;

import com.demo.dtos.FavoriteDTO;
import com.demo.entities.Favorite;
import com.demo.entities.Job;
import com.demo.repositories.FavoritePaginationRepository;
import com.demo.repositories.FavoriteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    private FavoritePaginationRepository favoritePaginationRepository;
    @Autowired
    private FavoriteRepository favoriteRepository;
    @Autowired
    private ModelMapper mapper; // Sử dụng ModelMapper để chuyển đổi giữa các đối tượng

    @Override
    public Page<FavoriteDTO> findBySeekerIdPagination(int seekerId, int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
        return favoritePaginationRepository.findBySeekerId(seekerId, pageable)
                .map(favorite -> mapper.map(favorite, FavoriteDTO.class));
    }

    @Override
    public boolean save(FavoriteDTO favoriteDTO) {
        try{
            Favorite favorite = mapper.map(favoriteDTO, Favorite.class);
            favorite.setCreated(new Date());
            favorite.setStatus(true);
            if(favoriteRepository.findByJobIdAndSeekerId(favoriteDTO.getJobId(), favoriteDTO.getSeekerId()) == null){
                favoriteRepository.save(favorite);
                return true;
            } else {
                return false;
            }
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }

    }
}
