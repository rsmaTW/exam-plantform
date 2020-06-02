package exam.quizcontext.domain.model.blankquiz;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BlankQuizTest {

    @Test
    void should_create_blank_quiz_successful() {

        BlankQuiz blankQuiz = BlankQuiz.create(new BlankQuizId("blankquizId"), "question", "answer");

        assertThat(blankQuiz, is(notNullValue()));

        assertThat(blankQuiz.getBlankQuizId(), is(new BlankQuizId("blankquizId")));
        assertThat(blankQuiz.getQuestion(), is("question"));
        assertThat(blankQuiz.getAnswer(), is("answer"));
        assertThat(blankQuiz.isDeleted(), is(false));
        assertThat(blankQuiz.getCreateTime(), instanceOf(LocalDateTime.class));
        assertThat(blankQuiz.getUpdateTime(), instanceOf(LocalDateTime.class));
        assertEquals(blankQuiz.getCreateTime(), blankQuiz.getUpdateTime());
    }

    @Test
    void should_update_blank_quiz_successful() {

        BlankQuiz blankQuiz = BlankQuiz.create(new BlankQuizId("blankquizId"), "question", "answer");

        blankQuiz.update("new-question", "new-answer");

        assertThat(blankQuiz, is(notNullValue()));

        assertThat(blankQuiz.getBlankQuizId(), is(new BlankQuizId("blankquizId")));
        assertThat(blankQuiz.getQuestion(), is("new-question"));
        assertThat(blankQuiz.getAnswer(), is("new-answer"));
        assertThat(blankQuiz.isDeleted(), is(false));
        assertThat(blankQuiz.getCreateTime(), instanceOf(LocalDateTime.class));
        assertThat(blankQuiz.getUpdateTime(), instanceOf(LocalDateTime.class));
        assertTrue(blankQuiz.getCreateTime().isEqual(blankQuiz.getUpdateTime()));
    }

    @Test
    void should_delete_blank_quiz_successful() {

        BlankQuiz blankQuiz = BlankQuiz.create(new BlankQuizId("blankquizId"), "question", "answer");

        blankQuiz.delete();

        assertThat(blankQuiz, is(notNullValue()));

        assertThat(blankQuiz.getBlankQuizId(), is(new BlankQuizId("blankquizId")));
        assertThat(blankQuiz.getQuestion(), is("question"));
        assertThat(blankQuiz.getAnswer(), is("answer"));
        assertThat(blankQuiz.isDeleted(), is(true));
        assertThat(blankQuiz.getCreateTime(), instanceOf(LocalDateTime.class));
        assertThat(blankQuiz.getUpdateTime(), instanceOf(LocalDateTime.class));
    }
}
