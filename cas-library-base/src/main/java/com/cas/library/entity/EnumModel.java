package com.cas.library.entity;

public class EnumModel {

	public enum StatusEnum {

		WAITING(0, "enum.status.waiting"), ACTIVE(1, "enum.status.active"), DEACTIVE(2, "enum.status.deactive");

		public int value;
		public String description;

		private StatusEnum(int value, String description) {
			this.value = value;
			this.description = description;
		}
	}

	public enum LevelEnum {

		HIGH(3),

		MEDIUM(2),

		LOW(1);

		private final int levelCode;

		private LevelEnum(int levelCode) {
			this.levelCode = levelCode;
		}

		public int getLevelCode() {
			return levelCode;
		}

	}

	public enum DayEnum {
		MON, TUE, WED, THUR, FRI, SAT, SUN;
	}

}
