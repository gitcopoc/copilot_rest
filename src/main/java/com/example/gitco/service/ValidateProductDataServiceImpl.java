package com.example.gitco.service;


import com.example.gitco.service.ValidateProductDataService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service(value = "ValidateProductDataService")
public class ValidateProductDataServiceImpl implements ValidateProductDataService {

	private static final String VALIDATE = "validate";
	private static final String COUNTRYID = "countryId";
	private static final String STORE_TYPE_ID = "storeTypeId";
	private static final String CATEGORY_ID = "categoryId";
	private static final String NOTIFICATION = "notification";
	private static final String PRICE_THRESHOLD_VALUE = "priceThresholdValue";
	private static final String VALIDATE_BY_CATEGORY_LEVEL = "validateByCategoryLevel";
	private static final String STOCK_THRESHOLD_VALUE = "stockThresholdValue";
	private static final String VALIDATE_BY_STORE_LEVEL = "validateByStoreLevel";
	private static final String VALIDATE_BY_COUNTRY_LEVEL = "validateByCountryLevel";
	private static final String MOVE_VALIDATIONS_TO_LOG_TABLE = "moveValidationsToLogTableAndClearValidations";
	private static final String TRIGGER_NOTIFICATIONS = "triggerNotifications";

	@Override
	public boolean validate() {
		boolean isValidated = true;
		// Get all active country
		List<Integer> countryIds = new ArrayList<>();
		countryIds.add(1);
		countryIds.add(2);
		List<String> validationParameters = List.of(new String[]{"123", "test"});
		for (Integer countryId : countryIds) {
			// Get distinct store from threshold
			List<Long> storeTypeIds = List.of(123L);
//			List<SoscThreshold> thresholds = soscThresholdRepository.findByCountryId(countryId,validationParameters);
			Integer priceFactId = getFactId("PRICE",56);
			Integer purchaseFactId = getFactId("PURCHASE",15);
			Integer stockFactId = getFactId("stock",12);
			Double historyDays = getHistoryDays(countryId);
			// For each store
			for (Long storeTypeId : storeTypeIds) {
				if (ObjectUtils .isNotEmpty(storeTypeId)) {
					List<Integer> categoryIds = List.of(1,2,4);
					for (Integer categoryId : categoryIds) {
						validateByCategoryLevel(countryId, storeTypeId, priceFactId, purchaseFactId, stockFactId,
								categoryId,  storeTypeIds.stream().filter(i -> ObjectUtils.isNotEmpty(i))
										.collect(Collectors.toList()),historyDays);

					}
					validateByStoreLevel(countryId, storeTypeId, priceFactId, purchaseFactId, stockFactId, categoryIds,
							historyDays);
				} else {
					// For store Type is null
					List<Integer> categoryIds = List.of(1,2,4);
					for (Integer categoryId : categoryIds) {
						validateByCategoryLevel(countryId, storeTypeId, priceFactId, purchaseFactId, stockFactId,
								categoryId,  storeTypeIds.stream().filter(i -> ObjectUtils.isNotEmpty(i))
										.collect(Collectors.toList()),historyDays);

					}
				}
			}
			// Validate by country that are not defined at category and store level
			validateByCountryLevel(countryId, priceFactId, purchaseFactId, stockFactId, validationParameters,historyDays);
		}
		triggerNotifications();
		return isValidated;
	}

	private Double getHistoryDays(Integer countryId) {
		return 10.0;
	}

	void validateByCategoryLevel(Integer countryId, Long storeTypeId, Integer priceFactId, Integer purchaseFactId,
			Integer stockFactId, Integer categoryId,  List<Long> storeTypeIds, Double historyDays) {

		// If Found, insert into validation table
		populateAndInsertSoscValidationData();
	}

	void validateByStoreLevel(Integer countryId, Long storeTypeId, Integer priceFactId, Integer purchaseFactId,
			Integer stockFactId, List<Integer> categoryIds,  Double historyDays) {

		// If Found, insert into validation table
		populateAndInsertSoscValidationData();
	}

	void validateByCountryLevel(Integer countryId, Integer priceFactId, Integer purchaseFactId, Integer stockFactId,
			 List<String> validationParameters, Double historyDays) {

		// If Found, insert into validation table
		populateAndInsertSoscValidationData();
		// If Found, insert into validation table
		populateAndInsertSoscValidationData( countryId, 15);
	}
	

	public Double getFactThreshold( Integer countryId, Long storeTypeId,
			Integer priceFactId, Integer categoryId) {

		return 13.00;
	}
	
	public Double getThresholdValueByCountryAndParameter(Integer countryId,String parameter) {
		return 12.0;	}

	public Integer getFactId(String factName, Integer countryId) {
		return countryId;
	}

	public void populateAndInsertSoscValidationData() {

	}
	
	public void populateAndInsertSoscValidationData(Integer countryId, Integer factId) {

	}

	@Async
	private void triggerNotifications() {
		try {
			System.out.println("trigger notification");
		} catch (Exception e) {

		}
	}
}
