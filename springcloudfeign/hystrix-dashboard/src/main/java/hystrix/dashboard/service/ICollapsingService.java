package hystrix.dashboard.service;

import hystrix.dashboard.model.Animal;

import java.util.concurrent.Future;

public interface ICollapsingService {
	public Future<Animal> collapsing(Integer id);
	public Animal collapsingSyn(Integer id);
	public Future<Animal> collapsingGlobal(Integer id);
	
}
