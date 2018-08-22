package com.consilx.monopolygame.helper;

import com.consilx.monopolygame.pojo.Tile;

/**
 * Creating circular linked list as we are treating Board as circular.Later we
 * can enahced this as generic circular linked list also.
 * 
 * @author jatin
 *
 * @param <T>
 */
public class CircularLinkedList<T> {
	private int size;
	private Tile head;

	/**
	 * Appending node
	 * 
	 * @param tile
	 */
	public void append(Tile tile) {
		if (null == tile) {
			return;
		}
		if (null == head) {
			head = tile;
			tile.setNext(tile);
			size++;
			return;
		} else {
			Tile temp = head;
			while (temp.getNext() != head) {
				temp = temp.getNext();
			}
			tile.setNext(temp.getNext());
			temp.setNext(tile);
			size++;
			return;
		}
	}

	/**
	 * Used to get Head of List
	 * 
	 * @return
	 */
	public Tile getHead() {
		if (null != head) {
			return head;
		}
		return null;
	}

	/**
	 * Used to get size of list.
	 * 
	 * @return
	 */
	public int getSize() {
		return size;
	}
}
