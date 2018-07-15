package ru.projects.Shop.interfaces.generic;

import java.util.List;

import ru.projects.Shop.entity.Region;

public interface RegionI {
	List<Region> findAllRegion();
	Region findRegionById(Long id);
	Region createRegion(Region region);
	Region updateRegion(Region region);
	void deleteRegion(Region region);

}
