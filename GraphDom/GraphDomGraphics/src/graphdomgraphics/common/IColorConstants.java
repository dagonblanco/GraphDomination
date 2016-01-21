/**
 * 
 */
package graphdomgraphics.common;

import org.eclipse.graphiti.util.ColorConstant;
import org.eclipse.graphiti.util.IColorConstant;

/**
 * @author xIS02028
 *
 */
public interface IColorConstants {

	public IColorConstant NODE_TEXT_FOREGROUND = IColorConstant.BLACK;
	public IColorConstant NODE_FOREGROUND = new ColorConstant(98, 131, 167);
	public IColorConstant NODE_BACKGROUND = new ColorConstant(187, 218, 247);
	public IColorConstant NODE_FOREGROUND_DOMINATING = new ColorConstant(168, 100, 98);
	public IColorConstant NODE_BACKGROUND_DOMINATING = new ColorConstant(248, 188, 189);
	public IColorConstant NODE_FOREGROUND_DOMINATED = new ColorConstant(168, 168, 168);
	public IColorConstant NODE_BACKGROUND_DOMINATED = new ColorConstant(188, 188, 188);
	
	public IColorConstant EDGE_FOREGROUND = NODE_FOREGROUND;
	public IColorConstant EDGE_BACKGROUND = NODE_BACKGROUND;
	public IColorConstant EDGE_FOREGROUND_DOMINATING = NODE_FOREGROUND_DOMINATING;
	public IColorConstant EDGE_BACKGROUND_DOMINATING = NODE_BACKGROUND_DOMINATING;

}
