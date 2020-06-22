package com.example.demo.Entity;

/**
 * 枚举类
 */
public class EnumEntity {
    public enum OperationTypeEnum {
        ADD("ADD", "添加") {},
        UPDATE("UPDATE", "修改") {},
        DELETE("DELETE", "删除") {},
        LOGIN("LOGIN", "登录") {};
        private String value;
        private String desc;

        private OperationTypeEnum(String value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public String getValue() {
            return value;
        }

        public String getDesc() {
            return desc;
        }

        public static OperationTypeEnum getOperationType(String value) {
            for (OperationTypeEnum v : OperationTypeEnum.values()) {
                if (value.equals(v.getValue())) {
                    return v;
                }
            }
            return null;
        }
    }

    public enum StatusEnum {
        SUCCESS("SUCCESS", "成功") {},
        FAILURE("FAILURE", "失败") {};
        private String value;
        private String desc;

        private StatusEnum(String value, String desc) {
            this.value = value;
            this.desc = desc;
        }

        public String getValue() {
            return value;
        }

        public String getDesc() {
            return desc;
        }

        public static StatusEnum getStatus(String value) {
            for (StatusEnum v : StatusEnum.values()) {
                if (value.equals(v.getValue())) {
                    return v;
                }
            }
            return null;
        }
    }
}
