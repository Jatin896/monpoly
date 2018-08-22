package com.consilx.monopolygame.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.consilx.monopolygame.constant.PropertyName;
import com.consilx.monopolygame.helper.CircularLinkedList;
import com.consilx.monopolygame.helper.BoardData;
import com.consilx.monopolygame.pojo.PropertyDetail;
import com.consilx.monopolygame.pojo.Tile;

/**
 * This class is used to get property details in board.And in future can be
 * enhanced to do operation related to Property(Like Sell property to some one).
 * 
 * @author jatin
 *
 */
@Service
public class PropertyService implements IPropertyService {

	/**
	 * This method is used to get all the all the property detail information.
	 */
	@Override
	public List<PropertyDetail> getAllPropertyDetails() {
		// TODO Auto-generated method stub
		List<PropertyDetail> propertyDetailsList = new ArrayList<PropertyDetail>();
		CircularLinkedList<Tile> boardCircularList = BoardData.boardCircularList;
		Tile head = boardCircularList.getHead();
		Tile temp = head;
		if (null != head) {
			while (temp.getNext() != head) {
				if (!(PropertyName.GO.getValue().equalsIgnoreCase(temp.getName())
						|| PropertyName.SPECIAL_TILE.getValue().equalsIgnoreCase(temp.getName()))) {
					addProperty(propertyDetailsList, temp);
				}
				temp = temp.getNext();
			}
			addProperty(propertyDetailsList, temp);
		}
		return propertyDetailsList;
	}

	public static void addProperty(List<PropertyDetail> propertyDetailsList, Tile temp) {
		PropertyDetail propertyDetail = new PropertyDetail();
		propertyDetail.setColour(temp.getColour());
		if (null != temp.getOwnerOfProperty() && null != temp.getOwnerOfProperty().getName()) {
			propertyDetail.setCurrentRentLevel(Integer.toString(temp.getCurrentRentLevel()));
			propertyDetail.setOwner(temp.getOwnerOfProperty().getName());
		} else {
			propertyDetail.setCurrentRentLevel("N/A");
			propertyDetail.setOwner("None (For sale)");
		}
		propertyDetail.setPropertyName(temp.getName());
		propertyDetailsList.add(propertyDetail);
	}
}
