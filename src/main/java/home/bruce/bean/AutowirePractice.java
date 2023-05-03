package home.bruce.bean;

import lombok.Data;

@Data
public class AutowirePractice {
    private Pig bigPig;

    public AutowirePractice(Pig p) {
        this.bigPig = p;
    }

    public AutowirePractice() {
    }
}
