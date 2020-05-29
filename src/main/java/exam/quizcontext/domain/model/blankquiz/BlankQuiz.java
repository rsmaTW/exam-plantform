package exam.quizcontext.domain.model.blankquiz;

import exam.shared.Entity;

import java.time.LocalDateTime;

public class BlankQuiz implements Entity<BlankQuiz> {

    private BlankQuizId blankQuizId;
    private String question;
    private String answer;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private BlankQuiz(BlankQuizId blankQuizId, String question, String answer, LocalDateTime createTime,
            LocalDateTime updateTime) {
        this.blankQuizId = blankQuizId;
        this.question = question;
        this.answer = answer;
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

    public BlankQuizId getBlankQuizId() {
        return blankQuizId;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    @Override
    public boolean sameIdentityAs(BlankQuiz other) {
        return blankQuizId.sameValueAs(other.getBlankQuizId());
    }
}
