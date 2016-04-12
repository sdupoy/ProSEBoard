package fr.eseo.ld.proseboard.mybatis.mappers;

import java.util.List;

import fr.eseo.ld.proseboard.models.Bill;

public interface BillMapper {
	List<Bill> getBillsForUserId(Long userId);
	List<Bill> getAllBills();
	void insert(Bill bill);
	void delete(Long billId);
	Bill getBillById(Long billId);
	
}


