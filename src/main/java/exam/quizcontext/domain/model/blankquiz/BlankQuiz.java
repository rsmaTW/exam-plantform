package exam.quizcontext.domain.model.blankquiz;

import exam.shared.Entity;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BlankQuiz implements Entity<BlankQuiz> {

    private BlankQuizId blankQuizId;
    private String question;
    private String answer;
    private boolean isDeleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private BlankQuiz(BlankQuizId blankQuizId, String question, String answer, LocalDateTime createTime,
            LocalDateTime updateTime) {
        this.blankQuizId = blankQuizId;
        this.question = question;
        this.answer = answer;
        this.isDeleted = false;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public static BlankQuiz create(BlankQuizId blankQuizId, String question, String answer) {
        LocalDateTime now = LocalDateTime.now();
        return new BlankQuiz(blankQuizId, question, answer, now, now);
    }

    public void update(String question, String answer) {
        LocalDateTime now = LocalDateTime.now();
        this.question = question;
        this.answer = answer;
        this.updateTime = now;
    }

    public void delete() {
        LocalDateTime now = LocalDateTime.now();
        this.isDeleted = true;
        this.updateTime = now;
    }

    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return blankQuizId.sameValueAs(other.getBlankQuizId());
    }
}
