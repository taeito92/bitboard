package dao;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.zerock.bitboard.dao.BoardDAO;
import org.zerock.bitboard.dto.AttachDTO;
import org.zerock.bitboard.dto.BoardDTO;
import org.zerock.bitboard.dto.PageDTO;

@Log4j2
public class BoardDAOTests {

    @Test
    public void testInsertWithAttach() {
        BoardDTO boardDTO = BoardDTO.builder()
                .title("Test")
                .content("Test")
                .writer("user1")
                .build();



        for(int i = 0; i < 3; i++){
            AttachDTO attachDTO = AttachDTO.builder()
                    .fname("file"+i+".jpg")
                    .savename(System.currentTimeMillis()+"_file"+i+".jpg")
                    .imgyn(true)
                    .build();
            boardDTO.addAttach(attachDTO);
        }

        log.info("=================================================");
        log.info(boardDTO);

        BoardDAO.INSTANCE.insert(boardDTO);
    }

    @Test
    public void testInsert() {
        BoardDTO boardDTO = BoardDTO.builder()
                .title("Test")
                .content("Test")
                .writer("user1")
                .build();

        BoardDAO.INSTANCE.insert(boardDTO);

        log.info("=================================================");
        log.info(boardDTO);
    }

    @Test
    public void testSelect(){
        log.info(BoardDAO.INSTANCE.select(3));
    }

    @Test
    public void testList(){

        PageDTO pageDTO = PageDTO.builder().page(3).build();

        BoardDAO.INSTANCE.list(pageDTO).forEach(boardDTO -> log.info(boardDTO));
    }

    @Test
    public void testDelete(){
        BoardDAO.INSTANCE.delete(1);
    }

    @Test
    public void testUpdate(){

        BoardDTO boardDTO =
                BoardDTO.builder().bno(3).title("update").content("update").build();
        BoardDAO.INSTANCE.update(boardDTO);
    }
}
